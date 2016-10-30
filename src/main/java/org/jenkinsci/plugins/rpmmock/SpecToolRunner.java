package org.jenkinsci.plugins.rpmmock;

import org.jenkinsci.plugins.rpmmock.cmdrunner.DefaultRunner;
import org.jenkinsci.plugins.rpmmock.cmdrunner.Param;

public class SpecToolRunner extends DefaultRunner {

    public SpecToolRunner(String cmdName) {
        super(cmdName);
    }

    public SpecToolRunner(){
        this("spectool");
    }

    public void setVerbose(){
        addParam(new Param("D", Param.ParamType.NO_VALUE));
    }



    public static SpecToolRunner buildSourceDownloader(String specFile, String sourceDir){
        final SpecToolRunner specToolRunner = new SpecToolRunner();
        specToolRunner.setSpecFile( specFile );
        specToolRunner.setSourceDir( sourceDir );
        specToolRunner.setDownloadSources();
        return specToolRunner;
    }

    public void setSourceDir(String sourceDir) {
	addParamWithValue("directory", sourceDir, Param.ParamType.CUSTOM);
    }

    public void setSpecFile(String specFile) {
        addParam( new Param( specFile, Param.ParamType.NO_VALUE_SHORT ) );
        addParam( new Param( "--get-files", Param.ParamType.NO_VALUE_SHORT ) );
    }

    public void setDownloadSources() {
        addParam( new Param( "R", Param.ParamType.NO_VALUE ) );
    }

}
