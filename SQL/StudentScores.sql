Select *,
Case
	When grade > 100 Then "Invalid Score"
	When grade < 0 Then "Invalid Score"
	When grade >= 90 Then "A"
	When grade >= 80 Then "B"
	When grade >= 70 Then "C"
	When grade >= 60 Then "D"
	Else "F"
End As LetterGrade
From studentscores
Order By grade DESC;