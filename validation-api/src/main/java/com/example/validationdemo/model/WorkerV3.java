package com.example.validationdemo.model;

import com.example.validationdemo.validation.groups.Create;
import com.example.validationdemo.validation.groups.Update;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
public class WorkerV3 {

    @Positive(groups = Update.class)
    private Long id;

    @NotNull(groups = {Create.class, Update.class})
    @Size(min = 2, max = 20, groups = {Create.class, Update.class})
    private String name;

    @NotNull(groups = Create.class)
    @Email(regexp = ".+@griddynamics\\.com", groups = Create.class)
    private String email;

}
