package com.tudelft.sdm.persistence.enumerations;

public enum QueryOperatorEnumeration
{
	SMALLER,
	SMALLER_OR_EQUAL,
	EQUAL,
	GREATER_OR_EQUAL,
	GREATER,
	IN;
	
	public QueryOperatorEnumeration fromSymbol(String symbol)
	{
		switch (symbol)
		{
			case "<":
				return SMALLER;
			case "<=":
				return SMALLER_OR_EQUAL;
			case "=":
				return EQUAL;
			case ">=":
				return GREATER_OR_EQUAL;
			case ">":
				return GREATER;
			case "in":
				return IN;
			default:
				throw new IllegalArgumentException();
		}
	}
}
