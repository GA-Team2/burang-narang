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

function searchAddressToCoordinate(address, day, seq) {
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
        let beforeDaySize = 0;

        if (day > 1) {
            for (let i = 1; i < day; i++) {
                beforeDaySize += spotSequence.get(i).length;
            }
        }

        addMarker(item, beforeDaySize, seq);
        drawPolyline(item, beforeDaySize, seq);

        map.setCenter(point);
    });
}

function addMarker(item, beforeDaySize, seq) {
    markers.splice((beforeDaySize + seq) - 1, 0, new naver.maps.Marker({
        position: new naver.maps.LatLng(item.y, item.x),
        map: map
    }));
}

function drawPolyline(item, beforeDaySize, seq) {
    polyline.getPath().insertAt((beforeDaySize + seq) - 1, new naver.maps.LatLng(item.y, item.x));
}

function moveSpotSequence(direction, day, seq) {
    let beforeDaySize = 0;

    if (day > 1) {
        for (let i = 1; i < day; i++) {
            beforeDaySize += spotSequence.get(i).length;
        }
    }

    if (direction === 'up') {
        moveUp(beforeDaySize, seq);
    } else if (direction === 'down') {
        moveDown(beforeDaySize, seq);
    }
}

function moveUp(beforeDaySize, seq) {
    moveUpPolyline(beforeDaySize, seq);
    moveUpMarker(beforeDaySize, seq);
}

function moveDown(beforeDaySize, seq) {
    moveDownPolyline(beforeDaySize, seq);
    moveDownMarker(beforeDaySize, seq);
}

function moveUpPolyline(beforeDaySize, seq) {
    const polylineTemp = polyline.getPath().getArray()[(beforeDaySize + seq) - 2];
    polyline.getPath().setAt((beforeDaySize + seq) - 2, polyline.getPath().getArray()[(beforeDaySize + seq) - 1]);
    polyline.getPath().setAt((beforeDaySize + seq) - 1, polylineTemp);
}

function moveUpMarker(beforeDaySize, seq) {
    const markerTemp = markers[(beforeDaySize + seq) - 2];
    markers[(beforeDaySize + seq) - 2] = markers[(beforeDaySize + seq) - 1];
    markers[(beforeDaySize + seq) - 1] = markerTemp;
}

function moveDownPolyline(beforeDaySize, seq) {
    const polylineTemp = polyline.getPath().getArray()[(beforeDaySize + seq)];
    polyline.getPath().setAt((beforeDaySize + seq), polyline.getPath().getArray()[(beforeDaySize + seq) - 1]);
    polyline.getPath().setAt((beforeDaySize + seq) - 1, polylineTemp);
}

function moveDownMarker(beforeDaySize, seq) {
    const markerTemp = markers[(beforeDaySize + seq)];
    markers[(beforeDaySize + seq)] = markers[(beforeDaySize + seq) - 1];
    markers[(beforeDaySize + seq) - 1] = markerTemp;
}

function deleteSpot(day, seq) {
    let beforeDaySize = 0;

    if (day > 1) {
        for (let i = 1; i < day; i++) {
            beforeDaySize += spotSequence.get(i).length;
        }
    }

    deleteSpotSequence(day, seq);
    deleteMarker(beforeDaySize, seq);
    deletePolyline(beforeDaySize, seq);
}

function deleteSpotSequence(day, seq) {
    spotSequence.get(day).splice(spotSequence.get(day).indexOf(seq), 1);

    for (let i = seq - 1; i < spotSequence.get(day).length; i++) {
        spotSequence.get(day)[i]--;
    }
}

function deleteMarker(beforeDaySize, seq) {
    const marker = markers[(beforeDaySize + seq) - 1];
    marker.setMap(null);
    markers.splice((beforeDaySize + seq) - 1, 1);
}

function deletePolyline(beforeDaySize, seq) {
    polyline.getPath().removeAt((beforeDaySize + seq) - 1);
}