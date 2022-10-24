const spotSequence = new Map();
let markers = [];

// 지도 옵션
const mapOptions = {
    center: new naver.maps.LatLng(35.157714, 129.059165),
    zoom: 16,
    minZoom: 10,
    zoomControl: true,
    zoomControlOptions: {
        position: naver.maps.Position.TOP_LEFT
    }
};
// 지도 생성
const map = new naver.maps.Map('map', mapOptions);

const polyline = new naver.maps.Polyline({
    map: map,
    path: [],
    strokeColor: '#FF0000',
    strokeWeight: 2
});

function initSpotSequence(tday) {
    for (let i = 1; i <= tday; i++) {
        spotSequence.set(i, []);
    }
}

function setSpotSequence(tday, seq) {
    spotSequence.get(tday).push(seq);
}

function moveUp(beforeDaySize, seq) {
    let temp = polyline.getPath().getArray()[(beforeDaySize + seq) - 2];
    polyline.getPath().setAt((beforeDaySize + seq) - 2, polyline.getPath().getArray()[(beforeDaySize + seq) - 1]);
    polyline.getPath().setAt((beforeDaySize + seq) - 1, temp);
}

function moveDown(beforeDaySize, seq) {
    let temp = polyline.getPath().getArray()[(beforeDaySize + seq)];
    polyline.getPath().setAt((beforeDaySize + seq), polyline.getPath().getArray()[(beforeDaySize + seq) - 1]);
    polyline.getPath().setAt((beforeDaySize + seq) - 1, temp);
}

function moveSpotSequence(direction, day, seq) {
    let beforeDaySize = 0;

    if (day > 1) {
        for (let i = 1; i < day; i++) {
            beforeDaySize += spotSequence.get(i).length - 1;
        }
    }

    if (direction === 'up') {
        moveUp(beforeDaySize, seq);
    } else if (direction === 'down') {
        moveDown(beforeDaySize, seq);
    }
}

function addMarker(item) {
    markers.push(new naver.maps.Marker({
        position: new naver.maps.LatLng(item.y, item.x),
        map: map
    }));
}

function drawPolyline(item) {
    polyline.getPath().push(new naver.maps.LatLng(item.y, item.x));
}

function searchAddressToCoordinate(address) {
    naver.maps.Service.geocode({
        query: address
    }, function (status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            if (!address) {
                return alert('Geocode Error, Please check address');
            }
            return alert('Geocode Error, address:' + address);
        }

        if (response.v2.meta.totalCount === 0) {
            return alert('No result.');
        }

        const item = response.v2.addresses[0];
        const point = new naver.maps.Point(item.x, item.y);

        addMarker(item);
        drawPolyline(item);

        map.setCenter(point);
    });
}