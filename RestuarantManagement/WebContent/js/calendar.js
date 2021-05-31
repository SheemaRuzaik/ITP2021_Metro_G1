 $(document).ready(function() {
    
    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,basicWeek,basicDay'
      },
      defaultDate: '2021-05-16',
      navLinks: true, // can click day/week names to navigate views
      editable: true,
      eventLimit: true, // allow "more" link when too many events
      events: [
        {
          title: 'Managers Meeting',
          start: '2021-04-01'
        },
        {
          title: 'Salary Date For All Employee',
          start: '2021-04-05',
          end: '2021-04-08'
        },
        {
          id: 999,
          title: 'Employee Meeting',
          start: '2021-04-09T14:00:00'
        },
        {
          id: 999,
          title: 'New Year Vacation and Ramazan Vacation',
          start: '2021-04-13',
		  end: '2021-04-16'
        },
        {
          title: 'New Employee Interview',
          start: '2021-04-19',
          end: '2021-04-21'
        },
        {
          title: 'May Day Leave',
          start: '2021-05-01'
        },
        {
          title: 'Managers Meeting',
          start: '2021-05-03T11:00:00'
        },
        {
          title: 'Salary Date For All Employee',
          start: '2021-05-05',
          end: '2021-05-08'
        },
        {
          title: 'Eid_Mubarak Vacation',
          start: '2021-05-12',
		  end: '2021-05-15'
        },
		{
          title: 'Vasak Vacation',
          start: '2021-05-26',
		  end: '2021-05-28'
        }
      ]
    });
    
  });