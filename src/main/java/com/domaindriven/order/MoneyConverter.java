package com.domaindriven.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class MoneyConverter implements AttributeConverter<Money, String> {

    /**
     * DB에 저장할 때는 특정 단위를 콤마(,)로 구분
     * ex) 1000000 = 1,000,000
     */
    @Override
    public String convertToDatabaseColumn(Money attribute) {
        final int UNDER_SPLITED = 999;
        int splitIndex = 1;
        Long money = attribute.getMoney();
        if (money <= UNDER_SPLITED) {
            return String.valueOf(money);
        }
        char[] moneyArray = String.valueOf(money).toCharArray();
        List<Character> resultCollection = new ArrayList<>();
        for (int i = 0; i < moneyArray.length; i++) {
            if (i == splitIndex) {
                resultCollection.add(',');
                splitIndex += 3;
            }
            resultCollection.add(moneyArray[i]);
        }
        return resultCollection.stream()
                               .map(String::valueOf)
                               .collect(Collectors.joining());
    }

    /**
     * 콤마(,)로 구분 된 DB 값을 숫자형 데이터로 Convert
     * ex) 1,000,000 = 1000000
     */
    @Override
    public Money convertToEntityAttribute(String dbData) {
        return new Money(Long.parseLong(dbData.replaceAll(",", "")));
    }
}
