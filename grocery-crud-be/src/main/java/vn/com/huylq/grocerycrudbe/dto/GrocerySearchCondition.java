package vn.com.huylq.grocerycrudbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrocerySearchCondition {

    private String name;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;

}
