////document.addEventListener("DOMContentLoaded", function () {
//    fetchChartData("headCircumChart", "Head Circumference");
//    fetchChartData("weightChart", "Weight");
//    fetchChartData("heightChart", "Height");
//    fetchChartData("bmiChart", "BMI");
//});
//
//function fetchChartData(chartId, label) {
//    fetch('/Pediatric/GrowthDataServlet', {
//        method: 'POST'
//        // Include other necessary options
//    })
//        .then(response => response.json()) // Assuming your servlet returns JSON data
//        .then(data => {
//            updateChart(chartId, label, data);
//        })
//        .catch(error => {
//            console.error('Error fetching chart data:', error);
//        });
//}
//
//function updateChart(chartId, label, data) {
//    var ctx = document.getElementById(chartId).getContext('2d');
//    new Chart(ctx, {
//        type: 'line',
//        data: {
//            labels: data.labels,
//            datasets: [{
//                label: label,
//                data: data.values,
//                fill: false,
//                borderColor: 'rgb(75, 192, 192)',
//                tension: 0.1
//            }]
//        },
//        options: {
//            scales: {
//                x: {
//                    type: 'linear',
//                    position: 'bottom',
//                    title: {
//                        display: true,
//                        text: 'Time (Months to Years)'
//                    }
//                },
//                y: {
//                    title: {
//                        display: true,
//                        text: 'Values'
//                    }
//                }
//            }
//        }
//    });
//}
//
//var data = {
//    labels: ['January', 'February', 'March', 'April', 'May'],
//    datasets: [{
//        label: 'Sample Line Data',
//        data: [10, 25, 30, 15, 20],
//        fill: false,
//        borderColor: 'rgba(75, 192, 192, 1)',
//        borderWidth: 2,
//        pointRadius: 5,
//        pointBackgroundColor: 'rgba(75, 192, 192, 1)',
//        pointBorderColor: 'rgba(75, 192, 192, 1)',
//        pointHoverRadius: 8,
//        pointHoverBackgroundColor: 'rgba(75, 192, 192, 1)',
//        pointHoverBorderColor: 'rgba(75, 192, 192, 1)',
//    }]
//};
//
//// Chart configuration
//var options = {
//    scales: {
//        y: {
//            beginAtZero: true
//        }
//    }
//};
//
//// Get the canvas element
//var ctx = document.getElementById('myLineChart').getContext('2d');
//
//// Create the line chart
//var myLineChart = new Chart(ctx, {
//    type: 'line',
//    data: data,
//    options: options
//});
//
//
