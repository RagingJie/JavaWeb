package com.naruto.mybatis.model.vo.requestVo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateEmpVo extends AddEmpVo implements Serializable {

    private static final long serialVersionUID = 4875189491651511L;

    @NotNull(message = "员工id不能为空")
    private Integer id;
}
