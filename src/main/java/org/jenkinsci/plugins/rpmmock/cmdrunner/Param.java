package org.jenkinsci.plugins.rpmmock.cmdrunner;

import java.text.MessageFormat;



public class Param {

    private boolean masked = false;

    public enum ParamType { SIMPLE, DEFAULT, CUSTOM, CUSTOM2, NO_VALUE, NO_VALUE_LONG, NO_VALUE_SHORT, NAMELESS  }

    private String name;
    private String value;
    private ParamType type = ParamType.DEFAULT;

    public Param(String name, ParamType type) {
        this.name = name;
        this.type = type;
    }

    public Param( String name ){
        this( name, ParamType.DEFAULT );
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean isMasked(){
        return masked;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return MessageFormat.format(getFormat(), new String[]{getName(), getValue()} );
    }

    public String getFormat() {
        switch( type ){
            case DEFAULT:
                return "--{0}=\"{1}\"";
            case CUSTOM:
                return "--{0}={1}";
            case CUSTOM2:
                return "--{0} \"{1}\"";
            case SIMPLE:
                return "-{0} {1}";
            case NO_VALUE:
                return "-{0}";
            case NO_VALUE_LONG:
                return "--{0}";
            case NO_VALUE_SHORT:
                return "{0}";
            case NAMELESS:
                return "{1}";
            default:
                return "";
        }
    }
}
