package jp.kuroda.sampleApimaven.dto;

import lombok.Data;

@Data
public class ZipcodeDataDto {
	String zipcode;
	String prefcode;
	String address1;
	String address2;
	String address3;
	String kana1;
	String kana2;
	String kana3;
}
