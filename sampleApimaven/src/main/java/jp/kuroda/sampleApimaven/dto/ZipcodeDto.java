package jp.kuroda.sampleApimaven.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ZipcodeDto {
	int status;
	String message;
	List<ZipcodeDataDto> results=new ArrayList<>();
}
