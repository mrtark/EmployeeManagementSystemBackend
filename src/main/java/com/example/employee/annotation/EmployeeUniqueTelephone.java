package com.example.employee.annotation;
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@javax.validation.Constraint(validatedBy = {EmployeeUniqueTelephoneValidation.class})
public @interface EmployeeUniqueTelephone {
    java.lang.String message() default "{employee.telephone.validation.constraints.unique.message}";
    java.lang.Class<?>[] groups() default {};
    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};
}
