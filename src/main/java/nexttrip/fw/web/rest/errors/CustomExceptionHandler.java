//package QLHP.fw.rest.errors;
//
//import QLHP.app.common.enums.SysError;
//import QLHP.fw.rest.vm.BaseResponse;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.EnumUtils;
//import org.hibernate.validator.internal.engine.path.PathImpl;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
////import vn.ngsdata.app.common.enums.SysError;
////import vn.ngsdata.fw.web.rest.vm.BaseResponse;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.constraints.NotNull;
//import java.util.ArrayList;
//import java.util.List;
//
//@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@Slf4j
//public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//        // ex.printStackTrace();
//        log.error(ex.getMessage());
//        return buildResponseEntity(BaseResponse.error(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public final ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {
//        log.error(ex.getMessage());
//        if (EnumUtils.isValidEnum(SysError.class, ex.getLocalizedMessage())) {
//            return buildResponseEntity(BaseResponse.error(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
//        }
//        return buildResponseEntity(BaseResponse.error(SysError.AUTHENTICATION_ERROR.name(), HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(InsufficientAuthenticationException.class)
//    public final ResponseEntity<Object> handleInsufficientAuthenticationException(InsufficientAuthenticationException ex, WebRequest request) {
//        log.error(ex.getMessage());
//        return buildResponseEntity(BaseResponse.error(SysError.INVALID_TOKEN_ERROR.name(), HttpStatus.UNAUTHORIZED.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(BadRequestException.class)
//    public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
//        // ex.printStackTrace();
//        log.error(ex.getMessage());
//        return buildResponseEntity(BaseResponse.error(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(ConflictException.class)
//    public final ResponseEntity<Object> handleConflictException(ConflictException ex, WebRequest request) {
//        log.error(ex.getMessage());
//        return buildResponseEntity(BaseResponse.error(ex.getLocalizedMessage(), HttpStatus.CONFLICT.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(LogicException.class)
//    public final ResponseEntity<Object> handleLogicException(LogicException ex, WebRequest request) {
//        log.error(ex.getMessage());
//        return buildResponseEntity(BaseResponse.error(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public final ResponseEntity<Object> handleIllegalArgumentException(NotFoundException ex, WebRequest request) {
//        // ex.printStackTrace();
//        log.error(ex.getMessage());
//        return buildResponseEntity(BaseResponse.error(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(TooManyRequestsException.class)
//    public final ResponseEntity<Object> handleTooManyRequestsException(TooManyRequestsException ex, WebRequest request) {
//        log.error(ex.getMessage());
//        return buildResponseEntity(BaseResponse.error(ex.getLocalizedMessage(), HttpStatus.TOO_MANY_REQUESTS.value()), HttpStatus.OK);
//    }
//
//    @Override
//    public @NotNull ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            @NotNull HttpHeaders headers,
//            @NotNull HttpStatus status,
//            @NotNull WebRequest request
//    ) {
//        List<FieldErrorResponse> details = new ArrayList<>();
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            FieldErrorResponse errorResponse = new FieldErrorResponse(error.getDefaultMessage(), error.getField());
//            details.add(errorResponse);
//        }
//        ObjectError error = ex.getBindingResult().getGlobalError();
//        if (error != null) {
//            FieldErrorResponse errorResponse = new FieldErrorResponse(error.getDefaultMessage(), "");
//            details.add(errorResponse);
//        }
//        return buildResponseEntity(BaseResponse.error(details, status.value()), HttpStatus.OK);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<Object> handleValidationException(ConstraintViolationException ex) {
//        List<FieldErrorResponse> details = new ArrayList<>();
//        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
//            FieldErrorResponse errorResponse = new FieldErrorResponse(constraintViolation.getMessage(), ((PathImpl) constraintViolation.getPropertyPath()).getLeafNode().getName());
//            details.add(errorResponse);
//        }
//        return buildResponseEntity(BaseResponse.error(details, HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
//    }
//
//    private ResponseEntity<Object> buildResponseEntity(BaseResponse<Object> baseResponse, HttpStatus status) {
//        return new ResponseEntity<>(baseResponse, status);
//    }
//
//    @Data
//    @AllArgsConstructor
//    static class FieldErrorResponse {
//        private String error;
//        private String field;
//    }
//}