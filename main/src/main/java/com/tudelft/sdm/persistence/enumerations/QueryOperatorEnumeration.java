package com.tudelft.sdm.persistence.enumerations;

public enum QueryOperatorEnumeration {
    SMALLER,
    GREATER_OR_EQUAL,
    EQUAL;

    public QueryOperatorEnumeration fromSymbol(String symbol) {
        switch (symbol) {
            case "<":
                return SMALLER;
            case ">=":
                return GREATER_OR_EQUAL;
            case "=":
                return EQUAL;
            default:
                throw new IllegalArgumentException();
        }
    }
}
