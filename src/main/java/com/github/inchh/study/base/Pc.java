package com.github.inchh.study.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * PC类
 *
 * @author In_Chh
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Pc implements Equipment {
    /**
     * PC型号
     */
    private String model;
    /**
     * 显示器型号
     */
    private String displayModel;

    @Override
    public String getDescription() {
        return model + "(" + displayModel + ")";
    }
}
