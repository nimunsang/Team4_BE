package com.ktc.matgpt.domain.chatgpt.service;

import com.ktc.matgpt.domain.chatgpt.dto.GptApiRequest;
import com.ktc.matgpt.domain.chatgpt.dto.GptApiResponse;
import com.ktc.matgpt.domain.chatgpt.dto.GptOrderGuidanceResponseDto;
import com.ktc.matgpt.domain.chatgpt.dto.GptRequestConverter;
import com.ktc.matgpt.domain.chatgpt.entity.GptOrderGuidance;
import com.ktc.matgpt.domain.chatgpt.repository.GptOrderGuidanceRepository;
import com.ktc.matgpt.domain.coin.dto.CoinRequest;
import com.ktc.matgpt.domain.coin.service.CoinService;
import com.ktc.matgpt.domain.user.entity.LocaleEnum;
import com.ktc.matgpt.domain.user.entity.User;
import com.ktc.matgpt.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class GptOrderGuidanceService {

    private final GptOrderGuidanceRepository gptOrderGuidanceRepository;
    private final UserService userService;
    private final CoinService coinService;
    private final GptApiService gptApiService;

    private static final int DEFAULT_COIN_USAGE = 20;


    @Transactional
    public String generateOrderGuidance(Long userId) {
        User user = userService.findById(userId);
        coinService.useCoin(userId,new CoinRequest.UseCoinDto(DEFAULT_COIN_USAGE));

        LocaleEnum locale = user.getLocale();
        return switch (locale) {
            case CHINESE -> "저는 중국 사람입니다. 너무 강한 향신료나 과한 양념은 기피하는 경향이 있습니다.";
            case SIMPLIFIED_CHINESE -> "저는 중국 사람입니다. 너무 강한 향신료나 과한 양념은 기피하는 경향이 있습니다.";
            case TRADITIONAL_CHINESE -> "저는 중국 사람입니다. 너무 강한 향신료나 과한 양념은 기피하는 경향이 있습니다.";
            case FRANCE -> "저는 프랑스 사람입니다. 과도한 맵기나 단맛, 가공 식품을 기피하는 경향이 있습니다.";
            case GERMANY -> "저는 독일 사람입니다. 과도한 단맛이나 너무 매운 음식, 그리고 기름진 해산물 요리를 기피하는 경향이 있습니다.";
            case ITALY -> "저는 이탈리아 사람입니다. 과도한 가공 식품이나 인공 첨가물을 사용한 요리를 기피합니다.";
            case JAPAN -> "저는 일본 사람입니다. 너무 짜거나 매운 음식, 지나치게 강한 향신료 사용은 기피하는 경향이 있습니다.";
            case KOREA -> "한국 사람입니다. 매운맛과 발효 음식(김치, 된장, 고추장)을 선호합니다.";
            case UK -> "저는 영국 사람입니다. 과도하게 매운 음식이나 지나치게 강한 맛의 요리는 상대적으로 기피하는 경향이 있습니다.";
            case US -> "저는 미국 사람입니다. 패스트푸드, 바비큐 류를 좋아합니다.";
            case CANADA -> "저는 캐나다 사람입니다. 지나치게 매운 음식이나 과도한 양념을 사용한 요리를 상대적으로 기피하는 경향이 있습니다.";
            case CANADA_FRENCH -> "저는 캐나다 사람입니다. 지나치게 매운 음식이나 과도한 양념을 사용한 요리를 상대적으로 기피하는 경향이 있습니다.";
        };
    }

//    @Transactional
//    public String generateOrderGuidance(Long userId) throws ExecutionException, InterruptedException {
//        User user = userService.findById(userId);
//        coinService.useCoin(userId,new CoinRequest.UseCoinDto(DEFAULT_COIN_USAGE));
//
//        GptApiRequest requestBody = GptRequestConverter.convertFromLocale(user.getLocale().getCountryDescription());
//
//        CompletableFuture<GptApiResponse> completableGptApiResponse = gptApiService.callChatGptApi(requestBody);
//        GptApiResponse gptApiResponse = completableGptApiResponse.get();
//
//        GptOrderGuidance gptOrderGuidance = GptOrderGuidance.create(user, gptApiResponse.getContent(), gptApiResponse.getCreatedLocalDateTime());
//        gptOrderGuidanceRepository.save(gptOrderGuidance);
//
//        return gptOrderGuidance.getContent();
//    }

    @Transactional(readOnly = true)
    public List<GptOrderGuidanceResponseDto> getOrderGuidances(Long userId) {
        List<GptOrderGuidance> gptOrderGuidances = gptOrderGuidanceRepository.findAllByUserId(userId);
        return gptOrderGuidances.stream()
                .map(GptOrderGuidanceResponseDto::new)
                .toList();
    }
}
