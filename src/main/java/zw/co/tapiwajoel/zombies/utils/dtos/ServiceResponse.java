package zw.co.tapiwajoel.zombies.utils.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ServiceResponse<T> {
    private String message;
    private T data;
}

