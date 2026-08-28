package nexttrip.app.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.payload.request.CreateExpenseRequest;
import nexttrip.app.domain.payload.request.CreateFinanceRequest;
import nexttrip.app.domain.payload.request.CreateTripRequest;
import nexttrip.app.service.FinanceService;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")

@RequestMapping("api/v1.0/finance")
public class FinanceController {

    private final FinanceService financeService;

    @PostMapping("")
    public BaseResponse<?> createFinance(@Valid @RequestBody CreateFinanceRequest request, @RequestParam Integer tripId) {
        log.info("Request POST /trip: {}", request);
        var response = financeService.createFinance(request, tripId);
        log.info("Response POST /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/detail/{id}")
    public BaseResponse<?> getFinanceDetail(@PathVariable("id") Integer tripId) {
        log.info("Request GET /trip: {}", tripId);
        var response = financeService.getFinanceDetail(tripId);
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @PostMapping("/expense")
    public BaseResponse<?> createExpense(@Valid @RequestBody CreateExpenseRequest request, @RequestParam Integer tripId) {
        log.info("Request POST /trip: {}", request);
        var response = financeService.createExpense(request, tripId);
        log.info("Response POST /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/expense_view/{tripId}")
    public BaseResponse<?> getListExpense(@PathVariable("tripId") Integer tripId) {
        log.info("Request GET /trip: {}", tripId);
        var response = financeService.getListExpense(tripId);
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/expense_general/{tripId}")
    public BaseResponse<?> getExpenseGeneral(@PathVariable("tripId") Integer tripId) {
        log.info("Request GET /trip: {}", tripId);
        var response = financeService.getExpenseGeneral(tripId);
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }

}
