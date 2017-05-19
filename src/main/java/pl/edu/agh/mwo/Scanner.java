package pl.edu.agh.mwo;

public class Scanner {

	String text;

	public Scanner(String init) {
		text = init;
	}

	public String get() {
		String result = "";
		boolean ok = false;
		while (!ok) {
			if (text.length() == 0) {
				return result;
			} else if (text.substring(0, 1).matches("[ \t\n]")) {
				text = text.substring(1);
			} else if (text.substring(0, 1).matches("%")) {
				while (!text.substring(0, 1).matches("\n")) {
					text = text.substring(1);
				}
			} else {
				ok = true;
			}
		}

		if (text.length() > 0 && text.substring(0, 1).matches("[()]")) {
			result = text.substring(0, 1);
			text = text.substring(1);
		}
		while (text.length() > 0 && !text.substring(0, 1).matches("[ \t\n%()]")) {
			result += text.substring(0, 1);
			text = text.substring(1);
		}
		return result.toLowerCase();
	}
}
