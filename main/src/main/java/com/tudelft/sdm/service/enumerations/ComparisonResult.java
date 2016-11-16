package com.tudelft.sdm.service.enumerations;

import java.math.BigInteger;

public enum ComparisonResult
{
	SMALLER,
	EQUAL,
	GREATER;
	
	public static ComparisonResult fromResult(BigInteger res)
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
