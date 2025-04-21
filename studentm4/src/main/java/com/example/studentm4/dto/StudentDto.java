package com.example.studentm4.dto;

import com.example.studentm4.model.StudentClass;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer id;

    @NotBlank(message = "Tên không được để trống!")
    @Pattern(regexp = "^[A-ZÀ-Ỹ][a-zà-ỹ]*(\\s[A-ZÀ-Ỹ][a-zà-ỹ]*)*$", message = "Tên không hợp lệ. Mỗi từ phải viết hoa chữ cái đầu và không chứa số!")
    private String name;

    @Min(value = 0, message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    private float point;

    @NotNull(message = "Phải chọn lớp học!")
    private StudentClass studentClass;

}
