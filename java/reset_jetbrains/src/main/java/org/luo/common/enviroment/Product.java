package org.luo.common.enviroment;

import org.luo.common.util.PropertiesUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum Product {
    IntelliJIdea{
        @Override
        public void delEvalFile(File config) {
            File[] files = config.listFiles();
            File configProperties = null;
            for (File file : files) {
                if (file.isFile() && file.getName().equals("idea.properties")) {
                    configProperties =  file;
                    break;
                }
            }
            String ideaConfigPath = config.getAbsolutePath();
            if (configProperties != null) {
                PropertiesUtil props = new PropertiesUtil(configProperties);
                ideaConfigPath = props.get("idea.config.path");
            }
            File otherFile = new File(ideaConfigPath + File.separator + "options" + File.separator + "other.xml");
            if (otherFile.exists()) {
                otherFile.delete();
            }
            File evalFolder = new File(ideaConfigPath + File.separator + "eval");
            ArrayList<File> evals = new ArrayList<>(evalFolder.listFiles().length);
            Collections.addAll(evals, evalFolder.listFiles());
            evals.forEach(File::delete);
            try {
                Runtime.getRuntime().exec("reg delete \"HKEY_CURRENT_USER\\Software\\JavaSoft\\Prefs\\jetbrains\" /f");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    GoLand {
        @Override
        public void delEvalFile(File config) {

        }
    },
    CLion {
        @Override
        public void delEvalFile(File config) {

        }
    },
    PyCharm {
        @Override
        public void delEvalFile(File config) {

        }
    },
    DataGrip {
        @Override
        public void delEvalFile(File config) {

        }
    },
    RubyMine {
        @Override
        public void delEvalFile(File config) {

        }
    },
    AppCode {
        @Override
        public void delEvalFile(File config) {

        }
    },
    PhpStorm {
        @Override
        public void delEvalFile(File config) {

        }
    },
    WebStorm {
        @Override
        public void delEvalFile(File config) {

        }
    },
    Rider {
        @Override
        public void delEvalFile(File config) {

        }
    };
    public abstract void delEvalFile(File config);
}
