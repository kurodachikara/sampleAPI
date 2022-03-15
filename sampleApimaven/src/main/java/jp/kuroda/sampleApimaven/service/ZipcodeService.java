package jp.kuroda.sampleApimaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jp.kuroda.sampleApimaven.dto.ZipcodeDto;

@Service
public class ZipcodeService {
	@Autowired
	@Qualifier("zipcodeSearchRestTemplate")
	RestTemplate restTemplate;
	
	private static final String URL="http://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";
	public ZipcodeDto service(String zipcode) {
		return restTemplate.getForObject(URL, ZipcodeDto.class, zipcode);
	}
}
