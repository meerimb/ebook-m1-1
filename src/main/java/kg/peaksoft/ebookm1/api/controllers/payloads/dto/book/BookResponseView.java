package kg.peaksoft.ebookm1.api.controllers.payloads.dto.book;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseView {

    List<BookResponse> bookResponses;
}
