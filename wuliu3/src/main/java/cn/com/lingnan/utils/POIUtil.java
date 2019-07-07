package cn.com.lingnan.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import cn.com.lingnan.pojo.Region;

public class POIUtil {
	private static Logger logger = Logger.getLogger(POIUtil.class);
	private final static String xls = "xls";
	private final static String xlsx = "xlsx";

	/**
	 * 读入excel文件，解析后返回
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static List<String[]> readExcel(MultipartFile file) throws IOException {

		// 获得Workbook工作薄对象
		Workbook workbook = getWorkBook(file);
		// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		List<String[]> list = new ArrayList<String[]>();
		if (workbook != null) {
			// 获得当前sheet工作表
			Sheet sheet = workbook.getSheetAt(0);
			if (sheet != null) {
				// 获得当前sheet的开始行
				int firstRowNum = sheet.getFirstRowNum();
				// 获得当前sheet的结束行
				int lastRowNum = sheet.getLastRowNum();
				// 循环除了第一行的所有行
				for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
					// 获得当前行
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// 获得当前行的开始列
					int firstCellNum = row.getFirstCellNum();
					// 获得当前行的列数
					int lastCellNum = row.getPhysicalNumberOfCells();
					String[] cells = new String[row.getPhysicalNumberOfCells()];
					// 循环当前行
					for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
						Cell cell = row.getCell(cellNum);
						cells[cellNum] = getCellValue(cell);
					}
					list.add(cells);
				}
				// workbook.close();
			}
		}
		return list;
	}

	/**
	 * 读入excel文件，解析后返回
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static List<Region> readRegionExcel(MultipartFile file) throws IOException {

		// 获得Workbook工作薄对象
		Workbook workbook = getWorkBook(file);
		// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		List<Region> regionList = new ArrayList<Region>();
		if (workbook != null) {
			// 获得当前sheet工作表
			Sheet sheet = workbook.getSheetAt(0);
			if (sheet != null) {
				// 获得当前sheet的开始行
				int firstRowNum = sheet.getFirstRowNum();
				// 获得当前sheet的结束行
				int lastRowNum = sheet.getLastRowNum();
				// 循环除了第一行的所有行
				for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
					// 获得当前行
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}

					String id = getCellValue(row.getCell(0));
					String province = getCellValue(row.getCell(1));
					String city = getCellValue(row.getCell(2));
					String district = getCellValue(row.getCell(3));
					String postcode = getCellValue(row.getCell(4));
					Region region = new Region(id, province, city, district, postcode, null, null);
					province = province.substring(0, province.length() - 1);
					city = city.substring(0, city.length() - 1);
					district = district.substring(0, district.length() - 1);
					String info = province + city + district;
					String[] headByString = PinYin4jUtils.getHeadByString(info);
					String shortcode = StringUtils.join(headByString);
					// 城市编码---->>shijiazhuang
					String citycode = PinYin4jUtils.hanziToPinyin(city, "");
					// 包装一个区域对象
					region.setShortcode(shortcode);
					region.setCitycode(citycode);
					System.out.println(region.toString());
					regionList.add(region);

				}
			}
		}
		return regionList;
	}

	// 检查文件
	public static void checkFile(MultipartFile file) throws IOException {
		// 判断文件是否存在
		if (null == file) {
			throw new FileNotFoundException("文件不存在！");
		}
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 判断文件是否是excel文件
		if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
			throw new IOException(fileName + "不是excel文件");
		}
	}

	public static Workbook getWorkBook(MultipartFile file) {
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		try {
			// 获取excel文件的io流
			InputStream is = file.getInputStream();
			// 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if (fileName.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(xlsx)) {
				// 2007 及2007以上
				workbook = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		return workbook;
	}

	/**
	 * [导出excel]
	 * 
	 * @param <T>
	 * @param excelHeader
	 *            表头
	 * @param excelHeadKey
	 *            字段名
	 * @param valueList
	 *            List<HashMap>格式数据
	 * @return
	 */
	public static <T> HSSFWorkbook exportExcel(String[] excelHeader, String[] excelHeadKey, List<T> valueList) {

		// 基本变量初始化
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet1");
		HSSFRow headerRow = hssfSheet.createRow(0);
		HSSFCellStyle headCellStyle = hssfWorkbook.createCellStyle();
		HSSFCellStyle dataCellStyle = hssfWorkbook.createCellStyle();
		int columnNum = excelHeader.length;

		// 样式设置
		headCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headCellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		headCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		dataCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		dataCellStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		dataCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dataCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dataCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dataCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dataCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		headerRow.setHeightInPoints(20);
		HSSFFont font = hssfWorkbook.createFont();
		font.setFontHeightInPoints((short) 12);
		headCellStyle.setFont(font);

		// 打印表头
		for (int i = 0; i < columnNum; i++) {
			HSSFCell headerCell = headerRow.createCell(i);
			headerCell.setCellValue(excelHeader[i]);
			headerCell.setCellStyle(headCellStyle);
			// 根据表头长度设置单元格宽度
			hssfSheet.setColumnWidth(i, excelHeader[i].getBytes().length * 2 * 180);
		}

		HSSFRichTextString richString=null;
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		Matcher matcher=null;
		Class tCls=null;
		Method getMethod=null;
		Object value=null;
		String textValue=null;
		String getMethodName=null;
		T t = null;
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		// 打印数据行
		for (int i = 0; i < valueList.size(); i++) {

			HSSFRow dataRow = hssfSheet.createRow(i + 1);
			dataRow.setHeightInPoints(20);
			for (int j = 0; j < excelHeader.length; j++) {
				HSSFCell cell = dataRow.createCell(j);
				getMethodName = "get" + excelHeadKey[j].substring(0, 1).toUpperCase() + excelHeadKey[j].substring(1);
				t=(T)valueList.get(i);
				tCls = t.getClass();
				try {
					getMethod = tCls.getMethod(getMethodName, new Class[] {});
					value = getMethod.invoke(t, new Object[] {});
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				// 判断值的类型后进行强制类型转换
				textValue = null;
				if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				} else if (value instanceof Float) {
					textValue = String.valueOf((Float) value);
					cell.setCellValue(textValue);
				} else if (value instanceof Double) {
					textValue = String.valueOf((Double) value);
					cell.setCellValue(textValue);
				} else if (value instanceof Long) {
					cell.setCellValue((Long) value);
				}
				if (value instanceof Boolean) {
					textValue = "是";
					if (!(Boolean) value) {
						textValue = "否";
					}
				} else if (value instanceof Date) {
					textValue = sdf.format((Date) value);
				} else {
					// 其它数据类型都当作字符串简单处理
					if (value != null) {
						textValue = value.toString();
					}
				}
				
				if (textValue != null) {
					matcher = p.matcher(textValue);
					if (matcher.matches()) {
						// 是数字当作double处理
						cell.setCellValue(Double.parseDouble(textValue));
					} else {
						richString = new HSSFRichTextString(textValue);
						cell.setCellValue(richString);
					}
				}

				cell.setCellStyle(dataCellStyle);
			}

		}

		return hssfWorkbook;

	}
	
	

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}
}
