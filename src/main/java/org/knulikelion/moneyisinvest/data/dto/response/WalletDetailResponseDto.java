package org.knulikelion.moneyisinvest.data.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class WalletDetailResponseDto {
    private String address;
    private String type;
    private String createdAt;
    private String balance;
    private String won;
}
