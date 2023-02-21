package com.example.employee.annotation;
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@javax.validation.Constraint(validatedBy = {EmployeeUniqueEmailValidation.class})
public @interface EmployeeUniqueEmail {
    java.lang.String message() default "{employee.email.validation.constraints.unique.message}";
    java.lang.Class<?>[] groups() default {};
    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};
}
