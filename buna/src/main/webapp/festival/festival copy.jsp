<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/test.css">
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/script.js"></script>
    <title>ì¶ì  / ì´ë²¤í¸</title>
</head>
<body>
    <section id="fest_wrap">
        <div class="inner">
            <h1 class="fest_title">ì¶ì  / ì´ë²¤í¸</h1>
            <div class="fest_month">
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item" role="presentation">
                      <button class="nav-link active" id="pills-1month-tab" data-bs-toggle="pill" data-bs-target="#pills-1month" type="button" role="tab" aria-controls="pills-1month" aria-selected="true">1ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-2month-tab" data-bs-toggle="pill" data-bs-target="#pills-2month" type="button" role="tab" aria-controls="pills-2month" aria-selected="false">2ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-3month-tab" data-bs-toggle="pill" data-bs-target="#pills-3month" type="button" role="tab" aria-controls="pills-3month" aria-selected="false">3ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-4month-tab" data-bs-toggle="pill" data-bs-target="#pills-4month" type="button" role="tab" aria-controls="pills-4month" aria-selected="false">4ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-5month-tab" data-bs-toggle="pill" data-bs-target="#pills-5month" type="button" role="tab" aria-controls="pills-5month" aria-selected="false">5ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-6month-tab" data-bs-toggle="pill" data-bs-target="#pills-6month" type="button" role="tab" aria-controls="pills-6month" aria-selected="false">6ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-7month-tab" data-bs-toggle="pill" data-bs-target="#pills-7month" type="button" role="tab" aria-controls="pills-7month" aria-selected="false">7ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-8month-tab" data-bs-toggle="pill" data-bs-target="#pills-8month" type="button" role="tab" aria-controls="pills-8month" aria-selected="false">8ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-9month-tab" data-bs-toggle="pill" data-bs-target="#pills-9month" type="button" role="tab" aria-controls="pills-9month" aria-selected="false">9ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-10month-tab" data-bs-toggle="pill" data-bs-target="#pills-10month" type="button" role="tab" aria-controls="pills-10month" aria-selected="false">10ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-13month-tab" data-bs-toggle="pill" data-bs-target="#pills-11month" type="button" role="tab" aria-controls="pills-11month" aria-selected="false">11ì</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-12month-tab" data-bs-toggle="pill" data-bs-target="#pills-12month" type="button" role="tab" aria-controls="pills-12month" aria-selected="false">12ì</button>
                    </li>
                  </ul>
            </div>            
            <div class="fest_list"> 
                <div class="tab-content" id="pills-tabContent">
                    <div class="tab-pane fade show active fest_hotList" id="pills-1month" role="tabpanel" aria-labelledby="pills-1month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=1062&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1" target="_blank">
                                <img src="images/20210409082940162_thumbL.jpg" alt=""></a></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><img src="images/20200701210502556_thumbL.jpg" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><img src="images/20200110131702589_thumbL.jpg" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-2month" role="tabpanel" aria-labelledby="pills-2month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-3month" role="tabpanel" aria-labelledby="pills-3month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-4month" role="tabpanel" aria-labelledby="pills-4month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-5month" role="tabpanel" aria-labelledby="pills-5month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-6month" role="tabpanel" aria-labelledby="pills-6month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-7month" role="tabpanel" aria-labelledby="pills-7month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-8month" role="tabpanel" aria-labelledby="pills-8month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-9month" role="tabpanel" aria-labelledby="pills-9month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-10month" role="tabpanel" aria-labelledby="pills-10month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-11month" role="tabpanel" aria-labelledby="pills-11month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-12month" role="tabpanel" aria-labelledby="pills-12month-tab">
                        <div class="fest_box" id="box1">
                            <div class="fest_img">1<img src="" alt=""></div>
                            <div class="fest_content">
                                <p>ì¸ê³ ìµê³ ì ì¼ì´í ì½ìí¸, ë¶ì°ììììíì¤í°ë²</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>