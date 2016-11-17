package com.tudelft.sdm.service;

import com.tudelft.comparison.Comparator;
import com.tudelft.paillier.EncryptedNumber;
import com.tudelft.paillier.PaillierContext;
import com.tudelft.paillier.PaillierPrivateKey;
import com.tudelft.sdm.service.enumerations.ComparisonResult;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service(value = "compareService")
class CompareService
{
	static ComparisonResult compare(BigInteger a, BigInteger b, PaillierPrivateKey sk)
	{
		Comparator      comp = new Comparator(sk);
		PaillierContext cxt  = sk.getPublicKey().createSignedContext();
		EncryptedNumber aEnc = new EncryptedNumber(cxt, a, 0);
		EncryptedNumber bEnc = new EncryptedNumber(cxt, b, 0);
		BigInteger      res  = comp.compare(aEnc, bEnc).decrypt(sk).decodeBigInteger();
		
		return ComparisonResult.fromResult(res);
	}
}
