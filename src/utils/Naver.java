package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import datamodel.BookParsing;

public class Naver {
	public static BookParsing naverkey(String searchText) {
		String clientId = ""; // ���ø����̼� Ŭ���̾�Ʈ ���̵�"
		String clientSecret = ""; // ���ø����̼� Ŭ���̾�Ʈ ��ũ����"

		 String text = null;
		try {
			text = URLEncoder.encode(searchText, "UTF-8");
			System.out.println(searchText);
			// System.out.println(text);

		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("�˻��� ���ڵ� ����", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&display=1&start=1"; // json
																													// ���
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // xml ���

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		System.out.println(responseBody);
		Gson gson = new Gson();
		BookParsing bookParsing = gson.fromJson(responseBody, BookParsing.class);

		return bookParsing;
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ȣ��
				return readBody(con.getInputStream());
			} else { // ���� �߻�
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API ��û�� ���� ����", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = null;
		try {
			streamReader = new InputStreamReader(body, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
		}
	}
}
