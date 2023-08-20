package com.example.snsproject.detailpage

object SampleDataManager {
    private var isInitialized = false

    fun initializeSampleData() {
        if (!isInitialized) {
            val sampleDetails = listOf(
                DetailInfo("신민지", "안녕하세요~", "나도 한마디 : 다 같이 으쌰으쌰해서 잘 마무리 해봅시다!!"),
                DetailInfo("이수진", "반갑습니다", "나도 한마디 : 3주 동안 잘 부탁드립니다 맡은 몫 열심히  하겠습니다 ~"),
                DetailInfo("전환휘", "잘부탁드리겠습니다", "나도 한마디: 저희 집 강아지 너무 귀여워요!"),
                //DetailInfo("이동희", "내배캠 모두 남은 기간 화이팅!!", "나도 한마디: 최선을 다해서 남은 기간 열심히 해보겠습니다!")
            )
            for (detail in sampleDetails) {
                DetailManager.addDetail(detail)
            }
            isInitialized = true
        }
    }
}