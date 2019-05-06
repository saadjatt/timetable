$(function() {
    "use strict";
    MorrisArea();
});

// Morris-chart
function MorrisArea() {
    Morris.Area({
        element: 'm_area_chart',
        data: [{
                period: '2014',
                Computar: 78,
                Sport: 205,
                Photoshop: 135
            }, {
                period: '2015',
                Computar: 180,
                Sport: 124,
                Photoshop: 140
            }, {
                period: '2016',
                Computar: 105,
                Sport: 100,
                Photoshop: 85
            },
            {
                period: '2017',
                Computar: 210,
                Sport: 180,
                Photoshop: 120
            }
        ],
        xkey: 'period',
        ykeys: ['Computar', 'Sport', 'Photoshop'],
        labels: ['Computar', 'Sport', 'Photoshop'],
        pointSize: 3,
        fillOpacity: 0,
        pointStrokeColors: ['#222222', '#cccccc', '#379c94'],
        behaveLikeLine: true,
        gridLineColor: '#e0e0e0',
        lineWidth: 2,
        hideHover: 'auto',
        lineColors: ['#222222', '#cccccc', '#379c94'],
        resize: true

    });   
}