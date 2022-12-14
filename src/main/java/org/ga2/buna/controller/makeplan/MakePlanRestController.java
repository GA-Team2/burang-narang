package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.service.makeplan.SavePlanDetail;
import org.ga2.buna.service.makeplan.SavePlanInfo;
import org.ga2.buna.service.makeplan.SaveTagList;
import org.ga2.buna.service.makeplan.SpotData;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/*
 * 플랜 작성 페이지
 *
 * @author 김규빈, 한애채
 */
@RestController
@AllArgsConstructor
@RequestMapping("/new")
@Slf4j
public class MakePlanRestController {
    private final SpotData spotData;
    private final SavePlanInfo savePlanInfo;
    private final SavePlanDetail savePlanDetail;
    private final SaveTagList saveTagList;

    /*
     * 장소 종류 받아와 spotList에 띄울 데이터 보내는 메서드
     *
     * @param kindOfSpot 장소 종류
     * @return 장소 데이터 리스트
     */
    @GetMapping("/spot")
    public List<SpotDTO> getSpotList(String kindOfSpot) {
        return spotData.findAll(kindOfSpot);
    }

    /*
     * 장소 이름 검색 시 spotList에 띄울 데이터 보내는 메서드
     *
     * @param spotName 장소 이름
     * @return 장소 데이터 리스트
     */
    @GetMapping("/search")
    public List<SpotDTO> searchSpotList(String spotName) {
        return spotData.findBySpotName(spotName);
    }

    /*
     * 플랜 인포 저장 및 태그 저장/업데이트
     *
     * @param planInfoDTO 플랜 인포 객체
     */
    @PostMapping("/planinfo")
    public void getFormData(@RequestBody PlanInfoDTO planInfoDTO) {
        savePlanInfo.save(planInfoDTO, savePlanInfo.maxByRowNumber() + 1);
        saveTagList.saveAll(planInfoDTO.getTagNameList());
    }

    /*
     * 플랜 디테일 저장
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     * @return 게시물 번호 반환
     */
    @PostMapping("/plandetail")
    public Integer getFormData(@RequestBody List<PlanDetailDTO> planDetailDTOList) {
        savePlanDetail.saveAll(planDetailDTOList);
        return savePlanInfo.maxByRowNumber();
    }

    /*
     * 로그인 확인
     *
     * @param session 회원 정보 담을 세션
     * @param nick    회원 닉네임
     */
    @GetMapping("/login")
    public void logIn(HttpSession session, String nick) {
        session.setAttribute("nick_s", nick);
        log.info("{} 님이 로그인했습니다.", nick);
    }
}
