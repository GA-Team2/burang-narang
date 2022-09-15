const closeBtn = document.querySelector(".modal_cancel");
const addBtn = document.querySelector(".modal_add");
const modal = document.querySelector(".modal_zone");

closeBtn.addEventListener("click", function () {
  modal.classList.add("hidden");
});

addBtn.addEventListener("click", function () {
  modal.classList.add("hidden");
});

function getValue(e) {
  let result = e.target.value;
  let tagValue = document.getElementById("tag").value;

  if (e.target.checked) {
    document.getElementById("tag").value += result + " ";
  } else {
    let idx = tagValue.indexOf(result);
    document.getElementById("tag").value = tagValue.replace(
      tagValue.substring(idx, idx + result.length + 1),
      ""
    );
  }
}
