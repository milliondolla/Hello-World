package za.co.tst;

import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class MyJson {

	public static void main(String[] args) {

		final String result = "{\"name\":\"Falco\",\"age\":3,\"bitable\":false}";
		final JsonParser parser = Json.createParser(new StringReader(result));
		String key = null;
		String value = null;
		while (parser.hasNext()) {
			final Event event = parser.next();
			switch (event) {
			case KEY_NAME:
				key = parser.getString();
				System.out.println(key);
				break;
			case VALUE_STRING:
				value = parser.getString();
				System.out.println(value);
				break;
			}
		}
		parser.close();
	}

}
