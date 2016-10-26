package com.tudelft.sdm.service.enumerations;

import java.math.BigInteger;

public enum ComparisonResultEnumeration
{
	SMALLER,
	EQUAL,
	GREATER;
	
	public static ComparisonResultEnumeration fromResult(BigInteger res)
	{
		switch (res.intValue())
		{
			case -1:
				return SMALLER;
			case 0:
				return EQUAL;
			case 1:
				return GREATER;
			default:
				throw new IllegalStateException();
		}
	}
}
