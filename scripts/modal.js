const closeBtn = document.querySelector(".modal_cancel");
const addBtn = document.querySelector(".modal_add");
const modal = document.querySelector(".modal_zone");
const tag = document.getElementsByClassName("highlight");

closeBtn.addEventListener("click", function () {
  modal.classList.add("hidden");
});

addBtn.addEventListener("click", function () {
  modal.classList.add("hidden");
});

tag.addEventListener("click", function () {
  const tagVal = tag.v;
});
