package com.strive.Func.ChapterI;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Sample3 {

    //static Logger logger = init(Level.DEBUG);

    public static void main(String[] args) {
       //logger.debug("{}",expensive());
    }

    static String expensive() {
        System.out.println("执行耗时操作...");
        return "日志";
    }

/*    static <AppenderComponentBuilder, BuiltConfiguration> Logger init(Level level) {
        ConfigurationBuilder <BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder()
                .setStatusLevel(Level.ERROR)
                .setConfigurationName("BuilderTest");
        AppenderComponentBuilder appender =
                builder.newAppender("Stdout","CONSOLE")
                        .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT)
                        .add(builder.newLayout("PatternLayout").addAttribute("pattern","%d [%t] %-5level:%smsg%n%throwab"));
        bulider.add(appender)
                .add(bulider.newRootLogger(level).add(bulider.newAppenderRef("Stout")));
        Configurator.initialize(bulider.build());
        return LogManager.getLogger();
    }*/

}
