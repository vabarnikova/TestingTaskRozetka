package logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FormatMsg extends Formatter {

    public String format(LogRecord record) {
        return record.getMessage() + "\n";
    }
}
