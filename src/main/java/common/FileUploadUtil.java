package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUploadUtil {
	
	/**
	 * 오늘 날짜를 반환하는 메서드
	 * 예) 2024년 4월 19일인 경우 반환값 => 20240419
	 * @return 오늘 날짜
	 */
	public static String getTodayDateString() {
	    Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return sdf.format(date);
	}
	
	
	/**
	 * 해당 경로에 폴더가 없을 경우 폴더를 생성하는 메서드
	 * @param directoryPath => 폴더를 생성하고자 하는 경로
	 */
	public static void createUploadDirectory(String directoryPath) {
	    File uploadDir = new File("C:" + directoryPath);
	    // 해당 경로가 없으면 폴더를 생성
	    if (!uploadDir.exists()) uploadDir.mkdir();
	}
	
	/**
	 * 유저가 등록한 파일의 파일명(originalFileName)에서 확장자만을 추출하고, UUID라는 랜덤 문자열과 확장자를 이어 붙여서 새로운 파일이름을 생성
	 * 파일명의 중복을 피하기 위해 사용
	 * 예) 84003cd6-39f3-4b2e-89a1-ff14898d1599.jpg (UUID 랜덤 문자열.확장자)
	 * @param originalFileName 유저가 전달한 파일명
	 * @return 랜덤 문자열.확장자
	 */
	public static String generateUniqueFileName(String originalFileName) {
		//사용자의 파일명에서 확장자만을 추출(.jpg, .png 등등)
	    String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
	    //UUID 메서드를 통해 랜덤 문자열을 만들고, 확장자를 이어 붙인다.
	    String newFileName = UUID.randomUUID().toString() + extension;
	    //위 예시와 같이 긴 파일명을 리턴
	    return newFileName;
	}
	
}
