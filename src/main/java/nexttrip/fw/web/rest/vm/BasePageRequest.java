package nexttrip.fw.web.rest.vm;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class BasePageRequest {
    @Range(min = 1)
    Integer pageIndex;

    @Range(min = 1)
    Integer pageSize;

    @Pattern(regexp = "^$|^([A-Za-z_]+,(?:DESC|ASC)\\|)*[A-Za-z_]+,(?:DESC|ASC)$")
    String sort;

    public BasePageRequest() {
        this.pageIndex = 1;
        this.pageSize = 20;
    }

    public Pageable toPageable() {
        if (pageIndex == null || pageSize == null) return Pageable.unpaged();
        if (!StringUtils.hasText(sort)) return PageRequest.of(pageIndex - 1, pageSize);
        List<Sort.Order> orders = Arrays.stream(sort.split("\\|")).map(s -> {
            String[] split = s.split(",");
            if (split.length < 2) return null;
            return new Sort.Order(split[1].equalsIgnoreCase("DESC") ?
                    Sort.Direction.DESC : Sort.Direction.ASC, split[0]);
        }).filter(Objects::nonNull).collect(Collectors.toList());
        return PageRequest.of(pageIndex - 1, pageSize, Sort.by(orders));
    }

    public Pageable toPageableAddSortDefault(Sort.Order... ordersDef) {
        if (pageIndex == null || pageSize == null) return Pageable.unpaged();
        if (!StringUtils.hasText(sort)) return PageRequest.of(pageIndex - 1, pageSize, Sort.by(ordersDef));
        List<Sort.Order> orders = Arrays.stream(sort.split("\\|")).map(s -> {
            String[] split = s.split(",");
            if (split.length < 2) return null;
            return new Sort.Order(split[1].equalsIgnoreCase("DESC") ?
              Sort.Direction.DESC : Sort.Direction.ASC, split[0]);
        }).filter(Objects::nonNull).collect(Collectors.toList());
        orders.addAll(Arrays.asList(ordersDef));
        return PageRequest.of(pageIndex - 1, pageSize, Sort.by(orders));
    }

//    public Boolean isNull() {
//        return pageIndex == null || pageSize == null;
//    }
}
