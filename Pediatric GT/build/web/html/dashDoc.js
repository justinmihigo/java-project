var data = {
    labels: ['January', 'February', 'March', 'April', 'May'],
    datasets: [{
        label: 'Sample Line Data',
        data: [10, 25, 30, 15, 20],
        fill: false,
        borderColor: 'rgba(75, 192, 192, 1)',
        borderWidth: 2,
        pointRadius: 5,
        pointBackgroundColor: 'rgba(75, 192, 192, 1)',
        pointBorderColor: 'rgba(75, 192, 192, 1)',
        pointHoverRadius: 8,
        pointHoverBackgroundColor: 'rgba(75, 192, 192, 1)',
        pointHoverBorderColor: 'rgba(75, 192, 192, 1)',
    }]
};

// Chart configuration
var options = {
    scales: {
        y: {
            beginAtZero: true
        }
    }
};

// Get the canvas element
var ctx = document.getElementById('myLineChart').getContext('2d');

// Create the line chart
var myLineChart = new Chart(ctx, {
    type: 'line',
    data: data,
    options: options
});


