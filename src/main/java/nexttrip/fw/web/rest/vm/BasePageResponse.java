package nexttrip.fw.web.rest.vm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor(force = true)
public class BasePageResponse<T> {
    private final List<T> items;
    private final Integer pageSize;
    private final Integer pageIndex;
    private final Long totalElements;
    private final Integer totalPages;

    public BasePageResponse(Page<T> page) {
        this.items = page.getContent();
        this.pageSize = page.getSize();
        this.pageIndex = page.getNumber() + 1;
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }

    public BasePageResponse(List<T> items, Integer pageIndex, Integer pageSize, Long totalElements, Integer totalPages) {
        this.items = items;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
}
