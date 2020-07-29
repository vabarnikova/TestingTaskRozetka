package logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class WebDriverLogs {
    protected static Logger log;
    protected static Handler handler;

    public Logger writeLogs(Class classN) {
        log = Logger.getLogger(classN.getName());
        handler = new ConsoleHandler();
        handler.setFormatter(new FormatMsg());
        log.setUseParentHandlers(false);
        log.addHandler(handler);
        return log;
    }
}
