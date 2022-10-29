const tagArea = document.getElementById("tag_area");
const duplicateTag = document.getElementById("duplicate_tag");
const tooManyTag = document.getElementById("too_many_tag");
const tooLongTag = document.getElementById("too_long_tag");
const blankTag = document.getElementById("blank_tag");
const addTagBtn = document.getElementById("add_tag");

/**
 * 태그 입력란의 추가 버튼을 클릭하면 태그 직접 추가
 */
addTagBtn.addEventListener("click", function () {
    directlyInsertTag();
});

/**
 * 태그 직접 추가
 */
function directlyInsertTag() {
    if (tagValidation()) {
        const tagName = document.getElementById("tag").value;
        createTag(tagName);
        document.getElementById("tag").value = "#";
    }
}

/**
 * 추천 태그를 클릭하여 태그 추가
 * @param 추천 태그
 */
function clickInsertTag(id) {
    if (tagValidation(id)) {
        createTag(id);
    }
}

/**
 * 태그 Area 안에 태그 생성
 * @param 태그명
 */
function createTag(tagName) {
    const tagId = tagName + "_in";
    const createTagSpan = document.createElement("span");
    document.getElementById("tag_value").value += tagName + " ";
    createTagSpan.id = tagId;
    createTagSpan.className = "highlight";
    createTagSpan.innerText = tagName;
    createTagSpan.onclick = function () {
        removeTag(tagId);
    };
    tagArea.appendChild(createTagSpan);
}

/**
 * 태그 Area 안의 태그를 클릭하면 태그 삭제
 * @param 태그 요소의 ID 값
 */
function removeTag(tag_id) {
    const tagValue = document.getElementById("tag_value").value;
    const result = tag_id.substring(0, tag_id.length - 3);
    const idx = tagValue.indexOf(result);

    document.getElementById("tag_value").value = tagValue.replace(tagValue.substring(idx, idx + result.length + 1), "");

    document.getElementById(tag_id).remove();
    validationInit();
}

/**
 * 태그 유효성 검사
 *
 * 호출시 기존의 유효성 검사 초기화
 *
 * 공통)
 * 1. 태그 Area에 태그가 10개 넘어갈 수 없다.
 * 2. 중복 추가 금지
 *
 * 직접 입력의 경우 -> directlyTagValidation()에서 유효성 추가 검사
 * @param (클릭 추가일 경우) ID 값
 * @returns 통과할 경우 true, 아니면 경고문 출력 후 false
 */
function tagValidation(...id) {
    const tagName = document.getElementById("tag").value;
    const tagValue = document.getElementById("tag_value").value;
    const tagValueList = document.getElementById("tag_value").value.split(" ");

    validationInit();

    if (id.length === 0 && !directlyTagValidation(tagName)) {
        return false;
    }

    if ((id.length !== 0 && tagValue.includes(id)) || (id.length === 0 && tagValue.includes(tagName))) {
        duplicateTag.classList.remove("hidden");
        return false;
    }

    if (tagValueList.length > 10) {
        tooManyTag.classList.remove("hidden");
        return false;
    }

    return true;
}

/**
 * 직접 입력 시의 태그 유효성 추가 검사
 *
 * 1. 초기값 # 추가 금지
 * 2. 11자 이상 태그명 금지
 *
 * @param 태그명
 * @returns 통과할 경우 true, 아니면 경고문 출력 후 false
 */
function directlyTagValidation(tagName) {
    if (tagName === "#") {
        blankTag.classList.remove("hidden");
        return false;
    }

    if (tagName.length > 11) {
        tooLongTag.classList.remove("hidden");
        return false;
    }

    return true;
}

/**
 * 유효성 검사 초기화
 */
function validationInit() {
    blankTag.classList.add("hidden");
    tooLongTag.classList.add("hidden");
    tooManyTag.classList.add("hidden");
    duplicateTag.classList.add("hidden");
}
