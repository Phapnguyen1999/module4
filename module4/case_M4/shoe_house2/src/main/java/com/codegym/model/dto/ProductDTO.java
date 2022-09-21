package com.codegym.model.dto;

import com.codegym.model.Category;
import com.sun.org.apache.xerces.internal.impl.validation.ValidationState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDTO {

    private Long id;

    @Size(min = 5, max = 50, message = "Tên sản phẩm có độ dài 5-10 kí tự!")
    @NotBlank(message = "Tên không được để trống!")
    private String name;

    private String image;

    private String quantity;

    private String price;

    private Category category;
}
