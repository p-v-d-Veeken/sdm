package com.tudelft.sdm.service;

import com.tudelft.paillier.PaillierPrivateKey;
import com.tudelft.sdm.service.enumerations.ComparisonResultEnumeration;

import java.math.BigInteger;

public interface CompareService
{
	ComparisonResultEnumeration compare(BigInteger a, BigInteger b, PaillierPrivateKey sk);
}