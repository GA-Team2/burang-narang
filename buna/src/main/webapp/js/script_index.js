// $(function() unchecked(){
//     $("Input:radio[name='radio_unchecked']'").prop('checked',false);
// });
$(document).ready(function () {
  $("#radio_unchecked").click(function () {
    $("input[type=radio][name=gnb]").prop("checked", false);
  });
});
