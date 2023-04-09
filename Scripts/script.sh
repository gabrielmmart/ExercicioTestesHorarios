cd ExercicioDosHorarios
sudo apt install mailutils
echo "Pipeline executado"
echo ${{Ambiente.MY_VARIABLE }}
echo "Mandando e-mail com mail do linux" | mail -s "meu email deu tudo certo" ${{Ambiente.MY_VARIABLE}}